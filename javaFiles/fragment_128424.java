'use strict';

var express = require('express');
var app = express(); 

var router = express.Router();  

router.get('/liste.json', function (req, res) {
  res.json([
    {
      "titre": "Le Parachutage",
      "auteur": "Norbert Zongo",
      "categorie": "Litterature",
      "editeur": "Harmattan",
      "prix": "400 UM"
    }
  ])
})

app.use('/api', router)

app.listen(8000)