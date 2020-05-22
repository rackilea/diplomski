private void setSub()
{
    try{

        client.subscribe(topic1,0);
        client.subscribe(topic2,0);
        client.subscribe(topic3,0);

    }
    catch (MqttException e){
        e.printStackTrace();
    }
}