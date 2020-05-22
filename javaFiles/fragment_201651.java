private static void addAButton(final String text, String BtnIcon,
        String PressBtnIcon, Container container, String name) {

  button.setName(name);
  button.addActionListener(new ButtonListener());
  ....
}