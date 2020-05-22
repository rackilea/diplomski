class Guy implements Singer, Writer{
  // Empty
}
Guy chris = new Guy();

hireWriter(chris); // Accepts "Writer" as it's parameter
hireSinger(chris); // Accepts "Singer" as it's parameter