Rule "insert message"
   when 
      Email ($message: message)
   then
      insert($message);
end