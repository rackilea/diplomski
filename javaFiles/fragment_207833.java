@Override
void contact(String purpose, String text) {
  if (this.merchant.hasEmailAddress()) {
    sendEmail(purpose, text, this.merchant.getEmail());
  } else {
    sendFax(purpose, text, this.merchant.getFaxNumber();
  }
}