/* start time measurement */
var start = Date.now();

/* perform actual operation */
for (i = 0; i < 40000; ++i) { 
  db.collection.insert({ }); /* whatever */ 
} 

/* print elapsed time since start */
print("elapsed time:", (Date.now() - start) / 1000.0, "s");