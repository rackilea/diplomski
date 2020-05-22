package mydatastore.collections.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @date 19.10.2012
 * @author Thomas Jahoda
 *
 * uses ReentrantReadWriteLock
 */
public class SecureArrayList<E> extends ArrayList<E> {

    protected final ReentrantReadWriteLock rwLock;
    protected final ReadLock readLock;
    protected final WriteLock writeLock;

    public SecureArrayList() {
        super();
        this.rwLock = new ReentrantReadWriteLock();
        readLock = rwLock.readLock();
        writeLock = rwLock.writeLock();
    }

    // write operations
    @Override
    public boolean add(E e) {
        try {
            writeLock.lock();
            return super.add(e);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void add(int index, E element) {
        try {
            writeLock.lock();
            super.add(index, element);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            writeLock.lock();
            return super.addAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        try {
            writeLock.lock();
            return super.addAll(index, c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            writeLock.lock();
            return super.remove(o);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public E remove(int index) {
        try {
            writeLock.lock();
            return super.remove(index);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            writeLock.lock();
            return super.removeAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        try {
            writeLock.lock();
            super.removeRange(fromIndex, toIndex);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public E set(int index, E element) {
        try {
            writeLock.lock();
            return super.set(index, element);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void clear() {
        try {
            writeLock.lock();
            super.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            writeLock.lock();
            return super.retainAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        try {
            writeLock.lock();
            super.ensureCapacity(minCapacity);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void trimToSize() {
        try {
            writeLock.lock();
            super.trimToSize();
        } finally {
            writeLock.unlock();
        }
    }

    //// now the read operations
    @Override
    public E get(int index) {
        try {
            readLock.lock();
            return super.get(index);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            readLock.lock();
            return super.contains(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            readLock.lock();
            return super.containsAll(c);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Object clone() {
        try {
            readLock.lock();
            return super.clone();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        try {
            readLock.lock();
            return super.equals(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int hashCode() {
        try {
            readLock.lock();
            return super.hashCode();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int indexOf(Object o) {
        try {
            readLock.lock();
            return super.indexOf(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Object[] toArray() {
        try {
            readLock.lock();
            return super.toArray();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() { // not sure if have to override because the size is temporarly stored in every case...
        // it could happen that the size is accessed when it just gets assigned a new value, 
        // and the thread is switched after assigning 16 bits or smth... i dunno
        try {
            readLock.lock();
            return super.isEmpty();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int size() {
        try {
            readLock.lock();
            return super.size();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            readLock.lock();
            return super.lastIndexOf(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        try {
            readLock.lock();
            return super.subList(fromIndex, toIndex);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        try {
            readLock.lock();
            return super.toArray(a);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public String toString() {
        try {
            readLock.lock();
            return super.toString();
        } finally {
            readLock.unlock();
        }
    }

    ////// iterators
    @Override
    public Iterator<E> iterator() {
        return new SecureArrayListIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new SecureArrayListListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new SecureArrayListListIterator(index);
    }
    // deligated lock mechanisms

    public void lockRead() {
        readLock.lock();
    }

    public void unlockRead() {
        readLock.unlock();
    }

    public void lockWrite() {
        writeLock.lock();
    }

    public void unlockWrite() {
        writeLock.unlock();
    }

    // getters
    public ReadLock getReadLock() {
        return readLock;
    }

    /**
     * The writeLock also has access to reading, so when holding write, the
     * thread can also obtain the readLock. But while holding the readLock and
     * attempting to lock write, it will result in a deadlock.
     *
     * @return
     */
    public WriteLock getWriteLock() {
        return writeLock;
    }

    protected class SecureArrayListIterator implements Iterator<E> {

        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public E next() {
            //  checkForComodification();
            int i = cursor;
            if (i >= SecureArrayList.super.size()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            lastRet = i;
            return SecureArrayList.super.get(lastRet);
        }

        @Override
        public void remove() {
            if (!writeLock.isHeldByCurrentThread()) {
                throw new IllegalMonitorStateException("when the iteration uses write operations,"
                        + "the complete iteration loop must hold a monitor for the writeLock");
            }
            if (lastRet < 0) {
                throw new IllegalStateException("No element iterated over");
            }
            try {
                SecureArrayList.super.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException(); // impossibru, except for bugged child classes
            }
        }
        //  protected final void checkForComodification() {
        //      if (modCount != expectedModCount) {
        //          throw new IllegalMonitorStateException("The complete iteration must hold the read or write lock!");
        //      }
        //  }
    }

    /**
     * An optimized version of AbstractList.ListItr
     */
    protected class SecureArrayListListIterator extends SecureArrayListIterator implements ListIterator<E> {

        protected SecureArrayListListIterator(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public E previous() {
            //  checkForComodification();
            int i = cursor - 1;
            if (i < 0) {
                throw new NoSuchElementException("No element iterated over");
            }
            cursor = i;
            lastRet = i;
            return SecureArrayList.super.get(lastRet);
        }

        @Override
        public void set(E e) {
            if (!writeLock.isHeldByCurrentThread()) {
                throw new IllegalMonitorStateException("when the iteration uses write operations,"
                        + "the complete iteration loop must hold a monitor for the writeLock");
            }
            if (lastRet < 0) {
                throw new IllegalStateException("No element iterated over");
            }
            //  try {
            SecureArrayList.super.set(lastRet, e);
            //  } catch (IndexOutOfBoundsException ex) {
            //      throw new ConcurrentModificationException(); // impossibru, except for bugged child classes
            //          EDIT: or any failed direct editing while iterating over the list
            //  }
        }

        @Override
        public void add(E e) {
            if (!writeLock.isHeldByCurrentThread()) {
                throw new IllegalMonitorStateException("when the iteration uses write operations,"
                        + "the complete iteration loop must hold a monitor for the writeLock");
            }
            //  try {
            int i = cursor;
            SecureArrayList.super.add(i, e);
            cursor = i + 1;
            lastRet = -1;
            //  } catch (IndexOutOfBoundsException ex) {
            //      throw new ConcurrentModificationException(); // impossibru, except for bugged child classes
            //          // EDIT: or any failed direct editing while iterating over the list
            //  }
        }
    }
}