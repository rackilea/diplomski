INSERT INTO MYTABLE (f1,f2,f3,f4) VALUES (1,2,3,4) ON DUPLICATE KEY UPDATE f4=5;

select count(*) as newCount from MYTABLE;

retrive OLDCOUNT and NEW COUNT

if(oldcount != new count)
{
  //InsertPerformed
}

else
{
  //updateperformed
}