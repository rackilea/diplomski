if (foodObjects != null && checked != null && objectsId != null) {
    for (i in 0 until foodObjects.size) {
        if (checked.get(i) == true) {
            objectsId.add(foodObjects.get(i).objectId)
        }
    }
}
else {
    // handle the case when one of the lists is null
}