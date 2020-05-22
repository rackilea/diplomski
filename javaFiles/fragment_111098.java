@Override
public void onStart() {
    super.onStart();
    presenter.onStart();

    Bundle bundle = this.getArguments();
    String day = Objects.requireNonNull(bundle).getString(SCHEDULE_DAY);
    presenter.requestScheduleAccordingToDay(day);
}