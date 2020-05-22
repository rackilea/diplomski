clicks.stream()
    .filter(click -> campaigns.stream()
        .filter(camp -> "prospecting".equals(camp.type))
        .anyMatch(camp -> 
            camp.campaignId == click.campaignId &&
            camp.end.after(click.date) &&
            camp.start.before(click.date)
        )
    )
    .collect(Collectors.toList());