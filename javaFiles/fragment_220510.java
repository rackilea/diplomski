$ cd /PATH/TO/JBoss-eap-7.0/bin
$ ./jboss-cli.sh -c

[standalone@localhost:9990 /] /subsystem=messaging-activemq/server=default/jms-queue=TestQ/:add(entries=["java:/jboss/exported/jms/queue/TestQ"])
  {"outcome" => "success"}

[standalone@localhost:9990 /] :reload
  {
    "outcome" => "success",
    "result" => undefined
  }