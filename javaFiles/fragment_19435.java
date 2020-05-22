if (this.targetListClass != null) {
    result = (List) BeanUtils.instantiateClass(this.targetListClass);
}
else {
    result = new ArrayList(this.sourceList.size());
}