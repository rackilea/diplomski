TrainingContent t = TRAINING_CONTENT.as("t");

create.update(TRAINING_CONTENT)
      .set(TRAINING_CONTENT.INDX,
           select(sum(t.INDX).minus(TRAINING_CONTENT.INDX))
           .from(t)
           .where(t.INDX.equal(index)
           .or(t.INDX.equal(index + (up ? -1 : +1))))
      );