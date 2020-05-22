while (!start.isAfter(end)) {
                totalDates.add(start);
                Milestones modelMilestones = new Milestones();
                modelMilestones .setMilestone(start.toString("MMMM dd, yyyy"));
                mDataList.add(modelMilestones);

                start = start.plusDays(1);
            }