boolean direction = rand.nextBoolean();

// 1 in 20 chance, same as 5 in 100, same as 50 in 1000 chance
if (rand.nextInt(20) == 0) { 
   direction = !direction;
}

if (direction) {
   // ... 
} else {
   // ...
}