package com.basilbourque.example;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// For a given name of day-of-week in some language, determine the matching `java.time.DayOfWeek` enum object.
// This class is the opposite of `DayOfWeek.getDisplayName` which generates a localized string for a given `DayOfWeek` object.
// Usage… DayOfWeekDelocalizer.of( Locale.CANADA_FRENCH ).parse( "lundi" ) → DayOfWeek.MONDAY
// Assumes `FormatStyle.FULL`, for day-of-week names without abbreviation.
// USE AT YOUR OWN RISK. Rough draft, quickly written. No serious testing.
public class DayOfWeekDelocalizer
{
    @NotNull
    private Locale locale;

    @NotNull
    private List < String > dayOfWeekNames, dayOfWeekNamesStandalone; // Some languages use an alternate spelling for a “standalone” day-of-week used without the context of a date.

    // Constructor. Private, for static factory method.
    private DayOfWeekDelocalizer ( @NotNull Locale locale )
    {
        this.locale = locale;

        // Populate the pair of arrays, each having the translated day-of-week names.
        int daysInWeek = 7; // Seven days in the week.
        this.dayOfWeekNames = new ArrayList <>( daysInWeek );
        this.dayOfWeekNamesStandalone = new ArrayList <>( daysInWeek );

        for ( int i = 1 ; i <= daysInWeek ; i++ )
        {
            this.dayOfWeekNames.add( DayOfWeek.of( i ).getDisplayName( TextStyle.FULL , this.locale ) );
            this.dayOfWeekNamesStandalone.add( DayOfWeek.of( i ).getDisplayName( TextStyle.FULL_STANDALONE , this.locale ) );
        }
//        System.out.println( this.dayOfWeekNames );
//        System.out.println( this.dayOfWeekNamesStandalone );
    }

    // Constructor. Private, for static factory method.
    // Personally, I think it unwise to default implicitly to a `Locale`. But I included this in case you disagree with me, and to follow the lead of the *java.time* classes. --Basil Bourque
    private DayOfWeekDelocalizer ( )
    {
        this( Locale.getDefault() );
    }

    // static factory method, instead of  constructors.
    // See article by Dr. Joshua Bloch. http://www.informit.com/articles/article.aspx?p=1216151
    // The `Locale` argument determines the human language and cultural norms used in de-localizing input strings.
    synchronized static public DayOfWeekDelocalizer of ( @NotNull Locale localeArg )
    {
        DayOfWeekDelocalizer x = new DayOfWeekDelocalizer( localeArg ); // This class could be optimized by caching this object.
        return x;
    }

    // Attempt to translate the name of a day-of-week to look-up a matching `DayOfWeek` enum object. 
    // Returns NULL if the passed String value is not found to be a valid name of day-of-week for the human language and cultural norms of the `Locale` specified when constructing this parent object, `DayOfWeekDelocalizer`.
    @Nullable
    public DayOfWeek parse ( @NotNull String input )
    {
        int index = this.dayOfWeekNames.indexOf( input );
        if ( - 1 == index )
        { // If no hit in the contextual names, try the standalone names.
            index = this.dayOfWeekNamesStandalone.indexOf( input );
        }
        int ordinal = ( index + 1 );
        DayOfWeek dow = ( ordinal > 0 ) ? DayOfWeek.of( ordinal ) : null;  // If we have a hit, determine the DayOfWeek. Else return null.
        return dow;
    }

    // `Object` overrides.

    @Override
    public boolean equals ( Object o )
    {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        DayOfWeekDelocalizer that = ( DayOfWeekDelocalizer ) o;

        return locale.equals( that.locale );
    }

    @Override
    public int hashCode ( )
    {
        return locale.hashCode();
    }

    public static void main ( String[] args )
    {
        // Quick testing.
        // DayOfWeekDelocalizer x = DayOfWeekDelocalizer.of( Locale.JAPAN );
        if ( DayOfWeekDelocalizer.of( Locale.CANADA_FRENCH ).parse( "lundi" ).equals( DayOfWeek.MONDAY ) )
        {
            System.out.println( "GOOD - Canada French 'lundi' is parsing to DayOfWeek.MONDAY." );
        } else
        {
            System.out.println( "BAD - Canada French 'lundi' is NOT parsing to DayOfWeek.MONDAY." );
        }
    }
}