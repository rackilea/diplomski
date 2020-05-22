str = str.replace("\"/*\"", "literal_string_open_comment");
str = str.replace("\"*/\"", "literal_string_close_comment");

int start =  str.indexOf("/*"), end = str.indexOf("*/");

while(start > -1 || end > -1) {
    if(start != -1) {
        if(end != -1) {
            if(end < start) {
                str = str.substring(end+2);
            } else {
                str = str.substring(0, start) + str.substring(end+2);
            }
        } else {
            str = str.substring(0, start);
        }
    } else {
        str = str.substring(end+2);
    }

    start =  str.indexOf("/*"); 
    end = str.indexOf("*/");
}

str = str.replace("literal_string_open_comment", "\"/*\"");
str = str.replace("literal_string_close_comment", "\"*/\"");