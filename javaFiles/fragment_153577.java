/**
 * This default implementation simply returns all headers that have no conflicts among the group. An absent header
 * on one or more Messages within the group is not considered a conflict. Subclasses may override this method with
 * more advanced conflict-resolution strategies if necessary.
 *
 * @param group The message group.
 * @return The aggregated headers.
 */
protected Map<String, Object> aggregateHeaders(MessageGroup group) {