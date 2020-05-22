public static void main(String[] args) throws IOException {
  PromptForMoney prompt = new PromptForMoney();
  try (Scanner in = new Scanner(System.in)) {
    prompt.prompt(in);
  }
  System.out.println(convert(prompt.getAmount(), prompt.getCurrency());
}