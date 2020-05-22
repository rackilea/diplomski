String compressDuration = /*...get it from wherever...*/;
compressDuration = compressDuration.trim();
int duration;
if (StringUtils.isBlank(compressDuration) || (duration = Integer.parseInt(compressDuration.trim())) < 0) {
    System.out.println("The compressDuration  has no value or a value less than zero");
} else {
    System.out.println("The compressDuration  is " + duration);
}