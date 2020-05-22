package com.sun.jna.platform;

import com.sun.jna.Library;


//@author windows-System

public class win32 {

 public interface Kernel32 extends Library {

 boolean Beep(int frequency, int duration); 
 // ... (lines deleted for clarity) ... }   
}