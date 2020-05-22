@Override
public boolean onOptionsItemSelected(MenuItem item) 
{
   switch (item.getItemId()) {
      case R.id.ic_action_microphone :
         MenuItem rec = m_menu.findItem(R.id.ic_action_microphone);
         if (m_start) {                
            rec.setIcon(R.drawable.ic_action_microphone_active);
            startRecording();
         } else {
            rec.setIcon(R.drawable.ic_action_microphone);
            stopRecording();
         }
         return true;
      default:
         return super.onOptionsItemSelected(item);
   }
}