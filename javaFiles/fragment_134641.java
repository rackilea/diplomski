import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import siapen.model.BaseEntity;

public class MeuInterceptador extends EmptyInterceptor {

    private static final long serialVersionUID = 7853236444153436270L;

    private String strSQL = "";
    String acao;
    @SuppressWarnings("rawtypes")
    BaseEntity entity;
    String s = "";

    @SuppressWarnings("unchecked")
    // 1
    public boolean onSave(Object obj, Serializable id, Object[] valores, String[] propertyNames, Type[] types)
            throws CallbackException {
        if (obj instanceof BaseEntity) {
            entity = (BaseEntity) obj;
            for (int i = 0; i < valores.length; i++) {
                if (valores[i] != null && !valores[i].equals("")) {
                    s += propertyNames[i] + ":" + valores[i];
                    if (i != valores.length - 1) {
                        s += "___";
                    }
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // 1
    public boolean onFlushDirty(Object obj, Serializable id, Object[] valoresAtuais, Object[] valoresAnteriores,
            String[] propertyNames, Type[] types) throws CallbackException {
        if (obj instanceof BaseEntity) {
            entity = (BaseEntity) obj;

            for (int i = 0; i < valoresAtuais.length; i++) {

                if (!ObjectUtils.equals(valoresAtuais[i], valoresAnteriores[i])) {
                    if (!s.equals("")) {
                        s += "___";
                    }
                    s += propertyNames[i] + "-Anterior:" + valoresAnteriores[i] + ">>>Novo:" + valoresAtuais[i];
                }
            }
        }
        return false;

    }

    @SuppressWarnings("unchecked")
    // 1
    public void onDelete(Object obj, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (obj instanceof BaseEntity) {
            entity = (BaseEntity) obj;
        }
    }

    // CHAMADO ANTES DO COMMIT
    // 2
    @SuppressWarnings("rawtypes")
    public void preFlush(Iterator iterator) {
    }

    // 3
    public String onPrepareStatement(String sql) {
        acao = "";
        if (sql.startsWith("/* update")) {
            acao = "update";
        } else if (sql.startsWith("/* insert")) {
            acao = "insert";
        } else if (sql.startsWith("/* delete")) {
            acao = "delete";
        }
        if (acao != null) {
            strSQL = sql;
        }
        return sql;
    }

    // CHAMADO APÓS O COMMIT
    // 4
    @SuppressWarnings("rawtypes")
    public void postFlush(Iterator iterator) {
        if (acao != null) {
            try {
                if (acao.equals("insert")) {
                    AuditLogUtil audi = new AuditLogUtil();
                    audi.LogIt("Salvo", entity, s);
                }
                if (acao.equals("update")) {
                    AuditLogUtil audi = new AuditLogUtil();
                    audi.LogIt("Atualizado", entity, s);
                }
                if (acao.equals("delete")) {
                    AuditLogUtil audi = new AuditLogUtil();
                    audi.LogIt("Deletado", entity, "");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                strSQL = "";
                s = "";
            }
        }
    }

}