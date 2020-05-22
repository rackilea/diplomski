for(RealmChapter chapter: realmUnit.getChapters) {
 chapter.getChapterGoals().clear();
}

realmUnit.getChapters().deleteAllFromRealm();
realmUnit.deleteFromRealm();