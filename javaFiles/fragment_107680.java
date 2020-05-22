public class BlinkFragment extends Fragment implements View.OnClickListener {

    ...

    public void onLedControlChanged(LedControl ledControl) {
        // change the view
        discrete_bl_g.setEnabled(ledControl.instance.data.expertMode);
        discrete_bl_h.setEnabled(ledControl.instance.data.expertMode);
    }

    public void onDisconnected() {
        // change the view
    }
}