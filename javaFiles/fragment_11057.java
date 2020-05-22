String input = "http://bits.wikimedia.org/w/extensions-1.17/" + 
               "MobileFrontend/stylesheets/webkit.css";

String replacement = "example.com";

String result = input.replaceAll("(http://).*?(/stylesheets/webkit\\.css)",
                "$1" + replacement + "$2");