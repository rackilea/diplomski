from("sftp://10.10.101.10/tmp/admin/?username=admin&password=admin123&antInclude=**/DOA*.txt")
    .log("date of admission ${body}");

from("sftp://10.10.101.10/tmp/admin/?username=admin&password=admin123&antInclude=**/PROFILE*.txt")
    .log("student profile ${body}");

from("sftp://10.10.101.10/tmp/admin/?username=admin&password=admin123&antInclude=**/RESULTS*.txt")
    .log("results ${body}");