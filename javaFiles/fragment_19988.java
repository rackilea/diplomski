import com4j.Variant;
import com4j.typelibs.ado20.ClassFactory;
import com4j.typelibs.ado20._Command;
import com4j.typelibs.ado20._Connection;
import com4j.typelibs.ado20._Recordset;

public static void queryADForComputers() throws Exception {

    String query            = "cn,sn,givenName,department";
    String filter           = "(&(objectclass=user)(objectcategory=person))";
    String namingContext    = "OU=Desktops,OU=Workstations,OU=HO,DC=win";
    _Connection conn        = ClassFactory.createConnection();

    conn.provider("ADsDSOObject");
    conn.open("Active Directory Provider","","",-1);

    _Command cmd            = ClassFactory.createCommand();
    cmd.activeConnection(conn);
    cmd.commandText("<LDAP://" + namingContext + ">;" + filter + ";" + query + ";subTree");
    _Recordset rs = cmd.execute(null, Variant.getMissing(), -1);
    System.out.println("Found " + rs.recordCount() + " users/computers/whatever i was looking for");

    //Then here you can use a while loop while(!rs.eof())
    //in which you can get each value as rs.fields().item(i).value();
    //in my case, i did rs.fields().item(i).value().toString()
    //or you can check for its type and go from there. 
}