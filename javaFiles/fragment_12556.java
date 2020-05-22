/*
 getMapLoaderSet: need a set with capacity 1, unique map
 getMapLoader: unique map to be accessed
 onMapLoaderSet: do some UI msg Toast on data
*/
interface MapIf<MapLoader>{
 Set<MapLoader> getMapLoaderSet(); 
 MapLoader getMapLoader();
 void onMapLoaderSet(Set<MapLoader> s);
}

public class MainActivity (Top Level) extends Activity{
 private MapLoader mMapLoader;
 private MapIf<MapLoader> mMapIf;
 @Override public void onCreate(...){
 /*unique set of 1; only 1 google map per application*/
 final int capacity = 1;
 this.mMapLoaderSet = new HashSet<>(capacity);
 mMapLoader = new MapLoader();
 mMapLoaderSet.add(mMapLoader);

 /*interface to share map accessibility*/
 mMapIf = new MapIf<MapLoader>() {
 @Override public Set<MapLoader> getMapLoaderSet() { return mMapLoaderSet; }
 @Override public MapLoader getMapLoader() { return mMapLoader; }
 @Override public void onMapLoaderSet(Set<MapLoader> s) { }
 };//mMapIf
 mMapIf.onMapLoaderSet(mMapLoaderSet);
}

public class SomeView (A) extends FragmentActivity implements OnClickListener, MapIf<MapLoader> {
 private Set<MapLoader> mMapLoaderSet;
 private MapLoader mMapLoader;
 @Override for OnCreate(...)
  mMapLoaderSet = ((MainActivity)context).getmMapLoaderSet();
  mMapLoader = mMapLoaderSet.iterator().next();
 }
 @Override for OnClickListener
 @Override for MapIf<MapLoader>
 @Override public Set<MapLoader> getMapLoaderSet() {
  return ((MainActivity)this.getApplicationContext()).getmMapLoaderSet();
 }
 @Override public MapLoader getMapLoader() {
  return ((MainActivity)this.getApplicationContext()).getmMapLoader();
 }
 @Override public void onMapLoaderSet(Set<MapLoader> s) { }
 }

public class MapLoader (B) extends Fragment implements 
 OnMapReadyCallback, MapIf<MapLoader> {
 /* same class members as SomeView (A)*/
 @Override for OnCreate(...)
 @Override for OnMapReadyCallback
 @Override for MapIf<MapLoader>
 /* same override implementation as SomeView (A)*/
 /* use getContext() instead of getApplicationContext()*/
}