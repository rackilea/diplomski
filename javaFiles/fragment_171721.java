@Override
public void onBindViewHolder(AssessmentViewHolder holder, int position) {
    Assessment assessment = assessmentList.get(position);
    holder.txtClientName.setText(assessment.getClient());
    holder.txtAssessmentDate.setText(assessment.getInspectedDate());
    holder.imageView.setTag(assessment.getId());
    holder.imageView.setOnClickListener(new OnDeleteIconClicked(position));
}