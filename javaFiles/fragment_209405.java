String compressDuration = /*...get it from wherever...*/;
compressDuration = compressDuration.trim();
int duration = StringUtils.isBlank(compressDuration) ? -1 : Integer.parseInt(compressDuration.trim();
if (duration < 0) {
    System.out.println("The compressDuration  has no value or a value less than zero");
} else {
    System.out.println("The compressDuration  is " + duration);
}