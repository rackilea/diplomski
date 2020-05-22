<?php



#API access key from Google API's Console



    define( 'API_ACCESS_KEY', 'YOUR_API_KEY');



    $topic = "/topics/todos";



$url = 'https://fcm.googleapis.com/fcm/send';

$fields = array (

        'to' => $topic,

        'notification' => array (

                "body" => "nova casa adicionada",

                "title" => "Nova casa",

                "sound"=> "default",

                "click_action"=> "Notification"

        ),

        'data' => array(

            "localcasa" => "Porto",

            "precocasa"=> "1.600.000 €",

            "imgurl"=> "http://brunoferreira.esy.es/imgsandroid/casa10.jpg",

            "infocs"=> "Apartamento localizado em local premium da cidade do Porto, à Avenida Marechal Gomes da Costa, onde pode viver-se com toda a calma e descontração. No ponto mais elevado da Foz, com vista de mar e uma envolvente de luxo, rodeado por moradias, com exteriores amplos e vistas deslumbrantes. É constituída por 4 quartos, 5 casas de banho e uma garagem em que tem a capacidade para 2 carros.",

            "csid"=> "10"

        )

);

$fields = json_encode ( $fields );

$headers = array (

        'Authorization: key=' . API_ACCESS_KEY,

        'Content-Type: application/json'

);



$ch = curl_init ();

curl_setopt ( $ch, CURLOPT_URL, $url );

curl_setopt ( $ch, CURLOPT_POST, true );

curl_setopt ( $ch, CURLOPT_HTTPHEADER, $headers );

curl_setopt ( $ch, CURLOPT_RETURNTRANSFER, true );

curl_setopt ( $ch, CURLOPT_POSTFIELDS, $fields );



$result = curl_exec ( $ch );

curl_close ( $ch );



?>