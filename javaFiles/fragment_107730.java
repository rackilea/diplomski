public Topic getTopics(String id) {
     for (Topic curTopic:topics) {
          if (curTopic.getId().equals(id)) return curTopic;
     }
     return null;
}