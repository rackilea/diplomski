while (!list.isEmpty()) {
            temp = list.pop();
            counter++;
            array.add(temp);
            System.out.println("Time " + totalTime + "\t Started task " + temp.id + "\t Staff: " + temp.staff + ", Task done " + temp.id);
            totalTime += temp.time;

            for (Task t : ids) {
                if (--t.cntPredecessors == 0) {
                    list.add(t);
                }
            }
        }