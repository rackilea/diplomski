create table course(id integer primary key, course_name varchar2(20));

<class name="Course" table="COURSE" >
  <id name="id">
    <!-- uses sequence, auto increment or whatever your DBMS uses for id generation -->
    <generator class="native"/> 
  </id>
  <property name="course">
    <column name="course"/>
  </property>
</class>