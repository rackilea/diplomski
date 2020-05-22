module.exports = {

/**
* Action blueprints:
*    `/gettoken/get`
*/
get: function (req, res) {

// Send a JSON response

  var java = require('java')
   java.classpath.push("C:/Users/cleuton/proj/sails.js/testProject/api/controllers/jsondao.jar")
  var javaObject = java.newInstanceSync("com.obomprogramador.sails.test.SampleJava")


    return res.json({
      hello: javaObject.getTokenSync()
    });
},


/**
* Overrides for the settings in `config/controllers.js`
* (specific to GetTokenController)
*/
_config: {}

};