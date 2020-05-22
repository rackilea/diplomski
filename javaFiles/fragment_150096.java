package ActionMathML;

import javax.xml.bind.*;

public class MarshalDemo {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance("ActionMathML");

        ObjectFactory objectFactory = new ObjectFactory();

        Utilisateur utilisateur = objectFactory.createUtilisateur();
        utilisateur.setCodeTraitement(0);
        utilisateur.setNomUtilisateur("nomok");
        utilisateur.setPassUtilisateur("passok");

        JAXBElement<TraitementDTO> jaxbElement = objectFactory.createCreate(utilisateur);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(jaxbElement, System.out);
    }

}