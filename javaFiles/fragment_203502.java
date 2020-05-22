String onePath     = "command_step_output/2019/02/13/ea768d46-85bb-4833-8326-fb6be6d60a89_20190213_105228_command_step_output.csv.gz";
    String anotherPath = "command_step_output/2019/02/13/ea768d46-85bb-4833-8326-fb6be6d60a89_20190213_105325_command_step_output.csv.gz";

    LocalDateTime oneTime = extractDateTime(onePath);
    LocalDateTime anboherTime = extractDateTime(anotherPath);

    Duration diff = Duration.between(oneTime, anboherTime);
    diff = diff.abs();