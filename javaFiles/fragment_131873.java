import backtype.storm.generated.KillOptions
import backtype.storm.generated.Nimbus.Client;
import backtype.storm.utils.NimbusClient
import backtype.storm.utils.Utils

Map conf = Utils.readStormConfig();
Client client = NimbusClient.getConfiguredClient(conf).getClient();
KillOptions killOpts = new KillOptions();
//killOpts.set_wait_secs(waitSeconds); // time to wait before killing
client.killTopologyWithOpts(topology_name, killOpts); //provide topology name