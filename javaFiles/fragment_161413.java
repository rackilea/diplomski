clicks.stream()
    .filter(click -> campaigns.stream()
        .filter(camp -> "pre".equals(camp.type))
        .anyMatch(camp -> accept(camp, click))
    )
    .collect(Collectors.toList());

static boolean accept(Campaign camp, Click click) {
    return camp.campaignId == click.campaignId &&
            camp.end.after(click.date) &&
            camp.start.before(click.date);
}