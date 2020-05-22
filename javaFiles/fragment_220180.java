> db.people.find({"NickNames.0":"Bob", "NickNames.1":"Mad man"}, {_id:0})
{ "Name" : "Trevor", "NickNames" : [ "Bob", "Mad man", "Tweedledee" ] }
{ "Name" : "Patrick", "NickNames" : [ "Bob", "Mad man" ] }
> db.people.find({"NickNames.0":"Bob"}, {_id:0})
{ "Name" : "Robert", "NickNames" : [ "Bob", "Twinkletoes" ] }
{ "Name" : "Trevor", "NickNames" : [ "Bob", "Mad man", "Tweedledee" ] }
{ "Name" : "Patrick", "NickNames" : [ "Bob", "Mad man" ] }
>