monthlyDao.save(goal);
List<Monthly> goals = monthlyDao.findAllList();
Assert.assertThat(goals.get(0).getTitle(), equalTo(goal.getTitle()));
monthlyDao.delete(goals.get(0)); // <-- Delete the goal returned from the find, which will have an ID
List<Monthly> updatedGoals = monthlyDao.findAllList();
Assert.assertTrue(updatedGoals.isEmpty());