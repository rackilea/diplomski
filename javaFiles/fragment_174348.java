PGM
         DCLPRCOPT  DFTACTGRP(*NO) ACTGRP(*NEW) BNDDIR(MYBNDDIR) +
                    USRPRF(*OWNER)
         DCL        VAR(&POINTER) TYPE(*PTR)

         ADDENVVAR  ENVVAR(CLASSPATH) +
                      VALUE('+
                        /java/poi-3.14/poi-3.14-mx.jar:+
                        /java/poi-3.14/poi-ooxml-3.14-mx.jar:+
                        /java/poi-3.14/ooxml-schemas-1.3.jar:+
                        /java/poi-3.14/lib/commons-codec-1.10.jar:+
                        /java/poi-3.14/lib/commons-logging-1.2.jar:+
                        /java/poi-3.14/lib/log4j-1.2.17.jar:+
                        /java/poi-3.14/ooxml-lib/xmlbeans-2.6.0.jar:+
                        /java/poix/poi-extend.jar:+
                        /java/javamail/javax.mail.jar:+
                        /java/rpgmail/rpgmail.jar:+
                        /java/prod/lib/mxSqlSvrJdbc.jar:+
                        /java/prod/lib/sqljdbc.jar:+
                        /java/prod/classes/cribMaster+
                      ') REPLACE(*YES)
         ADDENVVAR  ENVVAR(QIBM_RPG_JAVA_PROPERTIES) +
                      VALUE('+
                        -Djava.awt.headless=true;+
                        -Djava.net.preferIPv4Stack=true;+
                      ') REPLACE(*YES)

         ADDENVVAR  ENVVAR(QIBM_USE_DESCRIPTOR_STDIO) VALUE('Y') REPLACE(*YES)
         ADDENVVAR  ENVVAR(JAVA_HOME) +
                      VALUE('/QOpenSys/QIBM/ProdData/JavaVM/jdk80/32bit'+
                      ) REPLACE(*YES)
         ADDENVVAR  ENVVAR(QIBM_RPG_JAVA_EXCP_TRACE) VALUE('Y') REPLACE(*YES)

         CALLPRC    PRC(START_JVM) RTNVAL(&POINTER)
OUT:     ENDPGM