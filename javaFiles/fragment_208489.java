rule "test"
where 
  $o: Object()
then 
  $o.a = (! Condition);
end