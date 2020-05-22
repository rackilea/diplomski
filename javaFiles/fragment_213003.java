#!/bin/sh

app_name="vertx-web-0.1-fat.jar"

#::=== logger
logger_name="logback"

#::=== config
config_base="conf/web"
config_app="conf.json"
config_log="logback.xml"

#::=== arguments
args_factory_logger="org.vertx.logger-delegate-factory-class-name=org.vertx.java.core.logging.impl.SLF4JLogDelegateFactory"
args_classpath="conf/web:conf/web/lib/slf4j-api-1.7.12.jar:conf/web/lib/logback-classic-1.1.2.jar:conf/web/lib/logback-core-1.1.2.jar"

args_other="-cluster"

#::=== execute
java -D${args_factory_logger} -D$logger_name.configurationFile=$config_base/$config_log -jar $app_name -conf $config_base/$config_app ${args_other} -cp ${args_classpath}