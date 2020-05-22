for (Job job: list) {

    if (contiguous.isEmpty()) {
        /* First job added. Set 'isContiguousTillNow' to 'true' */
        contiguous.add(job);
        isContiguousTillNow = true;

    } else if (isContiguousTillNow && contiguous.get(contiguous.size() - 1).equals(job)) {
        /* The sequence has been contiguous till now, and the last job 
           added is equal to current job. Add the job. */
        contiguous.add(job);

    } else if (!contiguous.contains(job)) {
        /* Sequence is either broken here, or was already broken */
        /* But since the list doesn't already contains this job, add it,
           and this starts a new contiguous sequence. So, set it to 'true' */
        contiguous.add(job);
        isContiguousTillNow = true;

    } else {
        /* ContigousSequence stops here. So, set it to 'false' */
        isContiguousTillNow = false;
    }
}