-- make sure xpath_table is available
create extension xml2;

-- create XML staging table
create table xml_test (id integer, xml text);

-- create sample XML document
insert into xml_test  (id, data)
values
(1, '<person-list>
    <person>
        <id>42</id>
        <firstname>Arthur</firstname>
        <lastname>Dent</lastname>
    </person>
    <person>
        <id>43</id>
        <firstname>Zaphod</firstname>
        <lastname>Beeblebrox</lastname>
    </person>
</person-list>'
);