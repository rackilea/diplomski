%inline %{
int32_t void2int(jlong v) {
  return (intptr_t)v;
}

const char *void2str(jlong v) {
  return (const char*)v;
}
%}