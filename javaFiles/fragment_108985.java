<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JavaFX 2.0 - Ensemble</title>
  <SCRIPT src="http://java.com/js/dtjava.js"></SCRIPT>
  <script>
     function javafxEmbed_ensemble() {
       dtjava.embed(
         {
           id : 'ensemble',
           url : 'Ensemble.jnlp',
           placeholder : 'javafx-app-placeholder',
           width : '100%',
           height : '100%',
           jnlp_content : 'PD94b...o8L2pubHA+DQo='
         },
         {
           javafx : '2.0+'
         },
         {}
       );
     }
     <!-- Embed FX application into web page once page is loaded -->
     dtjava.addOnloadCallback(javafxEmbed_ensemble);
  </script>
  <style>
     html, body, #javafx-app-placeholder, #ensemble-app {  
       margin: 0;  
       overflow: hidden;  
       padding: 0; 
       width: 100%;
       height: 100%; 
     }
  </style>
</head>
<body><div id="javafx-app-placeholder"></div></body>
</html>