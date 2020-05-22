while (scan.hasNext()) {
   if (scan.hasNextDouble()) {
     double value = scan.nextDouble();
     out.println(value);
   } else {
     scan.next();
   }
}