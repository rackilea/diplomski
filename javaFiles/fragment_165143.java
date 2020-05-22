Scanner sc = new Scanner(System.in);
while (!sc.hasNextInt() && sc.hasNext()) {
  sc.next(); // advance / discard the invalid token
}

// we don't care about result of hasNext() here.
int select = sc.nextInt();