final StringBuilder sb = new StringBuilder(scenario.getScenarioID());
sb.append("\n");

scenario.getSectionList().
    // This filter has the same function as your if statement
    .filter(section -> !section.getLabelList().isEmpty())
    .forEach(section -> {
        sb.append("\t");
        sb.append(section.getSectionName());
        sb.append("\n");
        section.getLabelList().forEach(label -> {
            sb.append("\t\t");
            sb.append(label);
            sb.append("\n");
        });
    });

String format = sb.toString();