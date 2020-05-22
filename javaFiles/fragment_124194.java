statement = connection.prepareStatement(" declare " + "\n" +
"                        p_schema_name varchar2(400):= upper('" + schema + "');  "+"\n" +
"                        l_owner varchar2(400); "+"\n" +
"                        l_object_name varchar2(400); "+"\n"+ 
"                        cursor c1_views is "+"\n" +
"                            select "+"\n" +
"                                owner, "+"\n"+ 
"                                object_name "+"\n" +
"                            from dba_objects "+"\n" +
"                            where object_type in ('VIEW') "+"\n" + 
"                            and status = 'INVALID' "+"\n" +
"                            and owner = p_schema_name; "+"\n" +
"                    begin "+"\n" +
"                        open c1_views; "+"\n" +
"                        loop "+"\n" +
"                            fetch c1_views into l_owner,l_object_name;  "+"\n" + 
"                            if c1_views%notfound then "+"\n" +
"                                exit; "+"\n" + 
"                            else "+"\n" +
"                                execute immediate 'alter view    '||l_owner||'.'||l_object_name||' compile '; "+"\n" +
"                            end if; "+"\n" +
"                        end loop; "+"\n" +
"                        begin "+"\n" +
"                            dbms_utility.compile_schema(schema =>    p_schema_name); "+"\n" +
"                        end;   "+"\n" +
"                    end;");