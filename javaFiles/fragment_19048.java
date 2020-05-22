package com.praxis.desvucem.alarms.transformer;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.inject.Inject;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.praxis.desvucem.alarms.mensajes.Mensaje;
import com.praxis.desvucem.alarms.domain.MfCContactoAlarma;

    public class MailTransformer {

        private static Logger log = LoggerFactory.getLogger(MailTransformer.class);

        private String templateSufijo = "Email.vm";

        /**
         * Inyecta propiedades a from.
         */
        public @Value("#{mailProperties['mail.smtp.from']}")
        String from;

        /**
         * Inyecta propiedades a sendToUser.
         */
        public @Value("#{mailProperties['mail.send.user.default']}")
        String sendToUser;

        @Inject
        private VelocityEngine velocityEngine;

        @Inject
        private JavaMailSender mailSender;

        /**
         * Convierte mensajes de tipo Mensaje a MimeMessage y este pueda ser enviado
         * por el adaptador de mail.
         * @param msj {@link Mensaje} Mensaje Recive el mensaje
         * @return MimeMessage {@link MimeMessage} Regresa el mensaje convertido en
         * MimeMessage
         * @throws Exception al generar MimeMessage en MailTransformer
         */
        public MimeMessage mensajeToMimeMessage(Message<?> mensaje) {
            MfCContactoAlarma contactoAlarma = (MfCContactoAlarma) mensaje.getPayload();
            MessageHeaders header = mensaje.getHeaders();
            String mensajeReal = header.get("mensaje").toString();

            Map<String, Object> model = new HashMap<String, Object>();

            model.put("texto", mensajeReal);

            MimeMessage mimeMessage = null;

            String destinatarios = contactoAlarma.getConNombre();

            if (destinatarios == null) {

                log.info("Enviando mensaje  por correo al destinatario por defaul {}", sendToUser);
                // Se envia al usuario por default
                destinatarios = "sendToUser";
            }

            try {
                mimeMessage = armaMensajeConTextoDeTemplate(destinatarios, "Notificación automática VUCEM-MF", model,
                        "notificacion");
            }
            catch (Exception e) {
                log.error("Error al generar MimeMessage en MailTransformer ", e);
            }

            return mimeMessage;
        }

        private MimeMessage armaMensajeConTextoDeTemplate(String emails, String motivo, Map<String, Object> model,
                String template) throws MessagingException {

            String texto = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template + templateSufijo, "utf-8",
                    model);
            if (log.isDebugEnabled()) {
                log.debug("Texto del e-mail '" + texto + "'");
            }

            return armaMensaje(emails, motivo, texto);
        }

        private MimeMessage armaMensaje(final String emails, final String motivo, final String texto)
                throws MessagingException {

            MimeMessage mensaje = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mensaje);
            helper.addTo(emails);
            helper.setFrom(from);
            helper.setSubject(motivo);
            boolean isHTML = true;
            helper.setText(texto, isHTML);

            log.debug("Armando mensaje de correo, Para:[{}], De:[{}], Motivo:[{}] Mensaje:[{}]", emails, from, motivo,
                    texto);
            return mensaje;
        }
    }